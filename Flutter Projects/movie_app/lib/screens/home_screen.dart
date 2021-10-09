import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:movie_app/widgets/movie_list.dart';
import 'package:http/http.dart' as http;

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  Future<List<Map<String, dynamic>>> fetchAlbum() async {
    final response = await http
        .get(Uri.parse('https://jsonplaceholder.typicode.com/albums'));

    if (response.statusCode == 200) {
      // If the server did return a 200 OK response,
      // then parse the JSON.
      //return Album.fromJson(jsonDecode(response.body));
      // List<Map<String, dynamic>> list =
      //     response.body as List<Map<String, dynamic>>;
      //List<Map<String, dynamic>> list = jsonDecode(response.body);

      print(jsonDecode(response.body));
      return [];
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load album');
    }
  }

  @override
  Widget build(BuildContext context) {
    print(fetchAlbum());
    return Scaffold(
      appBar: AppBar(
          actions: [
            IconButton(
              //icon: const Icon(Icons.add_alert),
              icon: CircleAvatar(
                  backgroundImage: AssetImage("lib/assets/image1.jpg")),
              tooltip: 'Show Snackbar',
              onPressed: () {
                ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('This is a snackbar')));
              },
            ),
          ],
          automaticallyImplyLeading: false,
          centerTitle: true,
          title: const Text(
            'Movie App',
          )),
      // body: MovieList(),
      body: ListView(shrinkWrap: true, children: [
        MovieList("Kategorija 1"),
        MovieList("KAtegorija 2"),
        MovieList("KAtegorija 3"),
        MovieList("KAtegorija 4")
      ]),
    );
  }
}
