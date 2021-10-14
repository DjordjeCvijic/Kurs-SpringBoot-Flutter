import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:flutter/material.dart';
import 'package:movie_app/helpers/token.dart';

import '../const.dart';

class HomeProvider with ChangeNotifier {
  Future<List<Map<String, dynamic>>?> getContentByReleaseDate(
      int typeId) async {
    var apiUrl =
        '${Constants.baseUrl}/content/by-release-date?contentTypeId=$typeId';
    var token = await Token.getJwtToken();

    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br",
      "Authorization": "Bearer $token",
    };

    var res = await http.get(
      Uri.parse(apiUrl),
      headers: headers,
    );

    if (res.statusCode != 200) return null;

    var resList = (jsonDecode(utf8.decode(res.bodyBytes)) as List)
        .map((e) => e as Map<String, dynamic>)
        .toList();

    return resList;
  }

  Future<List<Map<String, dynamic>>?> getContentByRating(int typeId) async {
    var apiUrl = '${Constants.baseUrl}/content/by-rating?contentTypeId=$typeId';
    var token = await Token.getJwtToken();

    var headers = {
      "Content-Type": "application/json",
      "Accept": "*/*",
      "Accept-Encoding": "gzip, deflate, br",
      "Authorization": "Bearer $token",
    };

    var res = await http.get(
      Uri.parse(apiUrl),
      headers: headers,
    );

    if (res.statusCode != 200) return null;

    var resList = (jsonDecode(utf8.decode(res.bodyBytes)) as List)
        .map((e) => e as Map<String, dynamic>)
        .toList();

    return resList;
  }
}
