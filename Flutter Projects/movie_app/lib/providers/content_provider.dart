import 'dart:convert';
import 'dart:developer';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:movie_app/helpers/token.dart';

import '../const.dart';

class ContentProvider with ChangeNotifier {
  Future<List<Map<String, dynamic>>?> getContentByGenreAndType(
      int genreId, int typeId) async {
    var apiUrl = '${Constants.baseUrl}/content/by-category';
    var token = await Token.getJwtToken();

    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br",
      "Authorization": "Bearer $token",
    };

    var res = await http.post(
      Uri.parse(apiUrl),
      headers: headers,
      body: jsonEncode(
        {"genreId": genreId, "contentTypeId": typeId},
      ),
    );

    if (res.statusCode != 200) return null;

    var resList = (jsonDecode(utf8.decode(res.bodyBytes)) as List)
        .map((e) => e as Map<String, dynamic>)
        .toList();

    return resList;
  }

  Future<Map<String, dynamic>?> getContentDetails(int contentId) async {
    var apiUrl = Constants.baseUrl;
    var token = await Token.getJwtToken();

    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br",
      "Authorization": "Bearer $token",
    };

    var res = await http.get(
      Uri.parse('$apiUrl/content/details?contentId=$contentId'),
      headers: headers,
    );

    if (res.statusCode != 200) return null;

    return jsonDecode(utf8.decode(res.bodyBytes)) as Map<String, dynamic>;
  }

  Future<void> addComment(
    int contentId,
    String comment,
  ) async {
    var apiUrl = Constants.baseUrl;
    var token = await Token.getJwtToken();
    //da se dodje do id ulogovanog
    var parsedToken = await Token.decodeJWT();
    int userId = parsedToken!['userId'];

    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br",
      "Authorization": "Bearer $token",
    };

    var res = await http.post(
      Uri.parse('$apiUrl/user/comment'),
      body: jsonEncode(
        {
          "userId": userId,
          "contentId": contentId,
          "comment": comment,
          "replayId": null
        },
      ),
      headers: headers,
    );

    log(token.toString());
    log(res.statusCode.toString());
    if (res.statusCode != 200) return;

    notifyListeners();
  }
}
