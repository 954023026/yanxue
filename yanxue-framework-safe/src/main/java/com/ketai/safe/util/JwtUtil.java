package com.ketai.safe.util;


import com.ketai.common.constants.ResultCodeEnum;
import com.ketai.common.exception.KetaiException;
import io.jsonwebtoken.*;

import javax.servlet.ServletException;
import java.util.Date;

public class JwtUtil {
    /**
     * 私钥uuid   2168a0c2-7205-4162-a3c6-d50305374792
     */
    final static String base64EncodedSecretKey = "2168a0c2-7205-4162-a3c6-d50305374792";
    /**
     * 过期时间,默认设置5分钟
     */
    final static long TOKEN_EXP = 1000 * 60 * 30;

    public static String getToken(String userName,String roles){
        return Jwts.builder().setSubject(userName).claim("roles",roles).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+TOKEN_EXP)).signWith(SignatureAlgorithm.HS256,base64EncodedSecretKey).compact();
    }

    public static void main(String[] args) {
        getToken("12345","school");
    }

    /**
     * 判断token是否合法，不然抛出异常
     */
    public static Claims checkToken(String Token) throws ServletException {
        try {
            final Claims claims=Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(Token).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
           throw new KetaiException(ResultCodeEnum.USERLOGIN_INVALID_ERROR);
        } catch (UnsupportedJwtException e) {
            throw new KetaiException(ResultCodeEnum.USERUNLOGIN_ERROR);
        } catch (MalformedJwtException e) {
            throw new KetaiException(ResultCodeEnum.USERUNLOGIN_ERROR);
        } catch (SignatureException e) {
            throw new KetaiException(ResultCodeEnum.USERUNLOGIN_ERROR);
        } catch (IllegalArgumentException e) {
            throw new KetaiException(ResultCodeEnum.USERUNLOGIN_ERROR);
        }
    }
}
