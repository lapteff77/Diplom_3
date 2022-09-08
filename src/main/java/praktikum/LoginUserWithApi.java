package praktikum;

import static io.restassured.RestAssured.given;

public class LoginUserWithApi {

    private String email;
    private String password;
    private String name;
    private static String token;
    private static final int expectedCodeForOk = 200;
    private static final int expectedCodeForSetOver = 202;

    public LoginUserWithApi(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public LoginUserWithApi(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setOver(String email, String password) {
        LoginUserWithApi loginUserWithApiReg = new LoginUserWithApi(email, password);
        token = given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUserWithApiReg)
                .when()
                .post(AdressForUrl.urlApiLogin)
                .then()
                .log().all()
                .statusCode(expectedCodeForOk)
                .extract()
                .body()
                .path("accessToken");

        given()
                .auth()
                .oauth2(token.replace("Bearer ", ""))
                .delete(AdressForUrl.urlApiUser)
                .then()
                .log().all()
                .statusCode(expectedCodeForSetOver);
    }
}
