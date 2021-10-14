import 'dart:developer';

import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import 'package:movie_app/helpers/token.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../const.dart';
import 'dart:convert';

class LoginPovider extends ChangeNotifier {
  Future<bool> login(String username, String password) async {
    var apiUrl = "${Constants.baseUrl}/user/login";
    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br"
    };

    var res = await http.post(
      Uri.parse(apiUrl),
      headers: headers,
      body: jsonEncode({
        "username": username,
        "password": password,
      }),
    );

    if (res.statusCode != 200) return false;
    Token.saveToken(
        (jsonDecode(res.body) as Map<String, dynamic>)["jwt"].toString());
    return true;
  }

  Future<String?> getJwtToken() async {
    //da vrati null ako nema tokena
    var prefs = await SharedPreferences.getInstance();
    return prefs.getString("token");
  }
}
