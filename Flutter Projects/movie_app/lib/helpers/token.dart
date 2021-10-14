import 'dart:developer';

import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class Token {
  static Future<String?> getJwtToken() async {
    //da vrati null ako nema tokena
    var prefs = await SharedPreferences.getInstance();
    return prefs.getString("token");
  }

  static void saveToken(String token) async {
    var prefs = await SharedPreferences.getInstance();
    prefs.setString("token", token);
  }

  static Future<Map<String, dynamic>?> decodeJWT() async {
    var token = await getJwtToken();
    if (token == null) return null;

    Map<String, dynamic> payload = Jwt.parseJwt(token);
    return (payload);
  }
}
