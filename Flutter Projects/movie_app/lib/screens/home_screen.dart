import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:movie_app/providers/home_provider.dart';
import 'package:movie_app/widgets/movie_list.dart';
import 'package:http/http.dart' as http;
import 'package:movie_app/widgets/simple_tab.dart';
import 'package:provider/provider.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  var showMovies = true;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          toolbarHeight: 70,
          backgroundColor: Theme.of(context).scaffoldBackgroundColor,
          actions: [
            IconButton(
              iconSize: 70,
              //icon: const Icon(Icons.add_alert),
              icon: const CircleAvatar(
                  backgroundImage: AssetImage("lib/assets/userImage.jpg")),
              tooltip: 'Show Snackbar',
              onPressed: () {
                ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(content: Text('This is a snackbar')));
              },
            ),
          ],
          automaticallyImplyLeading: false,
          //centerTitle: ,
          title: const Text(
            'Pocetna',
            style: TextStyle(
                fontSize: 33, fontWeight: FontWeight.bold, color: Colors.white),
          )),
      // body: MovieList(),
      body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            //shrinkWrap: true,
            children: [
              Row(
                children: [
                  SimpleTab(
                    tabTitle: "Filmovi",
                    onTap: () {
                      setState(() {
                        showMovies = !showMovies;
                      });
                    },
                    active: showMovies,
                  ),
                  const SizedBox(
                    width: 20,
                  ),
                  SimpleTab(
                    tabTitle: "Serije",
                    onTap: () {
                      setState(() {
                        showMovies = !showMovies;
                      });
                    },
                    active: !showMovies,
                  ),
                ],
              ),
              Column(children: [
                FutureBuilder(
                    future: Provider.of<HomeProvider>(context)
                        .getContentByReleaseDate(
                      showMovies ? 1 : 2,
                    ), //ovdje moze bilo sta da se pozove
                    builder: (context,
                            AsyncSnapshot<List<Map<String, dynamic>>?>
                                snapshot) =>
                        snapshot.connectionState == ConnectionState.waiting
                            ? const CircularProgressIndicator()
                            : MovieList("Najnovije", snapshot.data)),
                const SizedBox(
                  height: 30,
                ),
                FutureBuilder(
                    future:
                        Provider.of<HomeProvider>(context).getContentByRating(
                      showMovies ? 1 : 2,
                    ), //ovdje moze bilo sta da se pozove
                    builder: (context,
                            AsyncSnapshot<List<Map<String, dynamic>>?>
                                snapshot) =>
                        snapshot.connectionState == ConnectionState.waiting
                            ? const CircularProgressIndicator()
                            : MovieList("Najviše ocjene", snapshot.data)),
              ]),
            ],
          )),
    );
  }
}
