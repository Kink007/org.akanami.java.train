package org.akanami;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.nio.charset.Charset;

public class jwtJJWTDemo01 {

    public static final String SECRET = "C6A5C7C5-2F5B-4412-B5BB-56428F63759F";
    public static final String ISSUER = "hngsIssuerV2";
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlYTJkZTY0N2E0ZDBkMmUzY2E4YmI2OWQ4ZDUzYmMiLCJYWlFIIjoiNDQwMSIsIlNKSENZIjoiMCIsImp0aSI6IjUyNGY1ZTc3LTYxYzYtNDdhMS05ZTE2LTgxYjk3YzhkM2UyZCIsImlhdCI6IjIwMjAvOS8xMSAxMDowNDoxNCIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJlYTJkZTY0N2E0ZDBkMmUzY2E4YmI2OWQ4ZDUzYmMiLCJZSE1DIjoiZWEyZGU2NDdhNGQwZDJlM2NhOGJiNjlkOGQ1M2JjIiwiWldNQyI6IuWQtOS6pue_lCIsIllITFgiOiIxIiwiQVBQIjoiWFNELE5DWVMiLCJuYmYiOjE1OTk4MTg2NTQsImV4cCI6MTYwMDQ2NjY1NCwiaXNzIjoiaG5nc0lzc3VlclYyIiwiYXVkIjoiaG5nc0F1ZGllbmNlVjIifQ.SXXPfpeGikxUBi51vDElRrSpExs8jyDg2DlxcyS_o-U";

    public static void main(String[] args) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes(Charset.forName("utf-8"))) // <----
                .build()
                .parseClaimsJws(TOKEN);

        System.out.println(claimsJws);
    }
}
