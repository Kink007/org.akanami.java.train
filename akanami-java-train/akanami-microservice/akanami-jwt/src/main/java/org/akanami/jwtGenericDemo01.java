//package org.akanami;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTCreator;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class jwtGenericDemo01 {
//
//    public static final String SECRET = "C6A5C7C5-2F5B-4412-B5BB-56428F63759F";
//    public static final String ISSUER = "hngsIssuerV2";
//    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlYTJkZTY0N2E0ZDBkMmUzY2E4YmI2OWQ4ZDUzYmMiLCJYWlFIIjoiNDQwMSIsIlNKSENZIjoiMCIsImp0aSI6IjUyNGY1ZTc3LTYxYzYtNDdhMS05ZTE2LTgxYjk3YzhkM2UyZCIsImlhdCI6IjIwMjAvOS8xMSAxMDowNDoxNCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJlYTJkZTY0N2E0ZDBkMmUzY2E4YmI2OWQ4ZDUzYmMiLCJZSE1DIjoiZWEyZGU2NDdhNGQwZDJlM2NhOGJiNjlkOGQ1M2JjIiwiWldNQyI6IuWQtOS6pue_lCIsIllITFgiOiIxIiwiQVBQIjoiWFNELE5DWVMiLCJuYmYiOjE1OTk4MTg2NTQsImV4cCI6MTYwMDQ2NjY1NCwiaXNzIjoiaG5nc0lzc3VlclYyIiwiYXVkIjoiaG5nc0F1ZGllbmNlVjIifQ.SXXPfpeGikxUBi51vDElRrSpExs8jyDg2DlxcyS_o-U";
//
//    public static void main(String[] args) {
//        try {
//            Map<String, String> map = verifyToken(TOKEN);
//            System.out.println(map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String genToken(Map<String, String> claims, Date expireDatePoint) {
//
//        try {
//            //使用HMAC256进行加密
//            Algorithm algorithm = Algorithm.HMAC256(SECRET);
//
//            //创建jwt
//            JWTCreator.Builder builder = JWT.create().
//                    withIssuer(ISSUER). //发行人
//                    withExpiresAt(expireDatePoint); //过期时间点
//
//            //传入参数
//            claims.forEach((key, value) -> {
//                builder.withClaim(key, value);
//            });
//
//            //签名加密
//            return builder.sign(algorithm);
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 解密jwt
//     *
//     * @param token
//     * @return
//     * @throws RuntimeException
//     */
//    public static Map<String, String> verifyToken(String token) throws RuntimeException {
//        Algorithm algorithm = null;
//        try {
//            //使用HMAC256进行加密
//            algorithm = Algorithm.HMAC256(SECRET);
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
////        } catch (UnsupportedEncodingException e1) {
////            throw new RuntimeException(e1);
////        }
//        }
//        //解密
//        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
//        DecodedJWT jwt = verifier.verify(token);
//        Map<String, Claim> map = jwt.getClaims();
//        Map<String, String> resultMap = new HashMap<>();
//        System.out.println("resultmap:" + resultMap);
//        map.forEach((k, v) -> resultMap.put(k, v.asString()));
//        return resultMap;
//    }
//}
