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
      //List<Map<String, dynamic>> list =  (response.body);

      //print(jsonDecode(response.body));
      return [];
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load album');
    }
  }

  final List<Map<String, dynamic>> _najgledanije = [
    {
      "name": "Ko to tamo peva",
      "trailer": "https://www.youtube.com/watch?v=ZwozSLas8DM",
      "description": "Opis filma",
      "image": "lib/assets/film1Slika.jpg"
    },
    {
      "name": "Mi nismo andjeli 2",
      "trailer": "https://www.youtube.com/watch?v=vuoSWtL3GZ8",
      "description":
          "Никола је и даље заводник иако су године учиниле своје. Безбрижну рутину београдског швалера драматично прекида његова ћерка мезимица Софија, која тек што је напунила 15 година, а „напаљени“ тинејџери почињу да наваљују на њена врата.Све донедавно Софија је била класична мушкарача која са татом иде на утакмице и пуца у пеинт бол арени (тата је власник пеинт бол клуба „Мали Стаљинград“). Онда, за 15. рођендан, његова бивша супруга Марина и њена пријатељица Виолета Зубић унајмљују модне и козметичке експерте који ће од „ружног пачета“ направити „секси лабуда“.Ипак, прави пакао за Николу настаје тек кад Марина и Виолета оду на недељу дана у Рим и препусте њему бригу о Софији. Притиснут буљуцима удварача, Никола почиње да луди и користи трикове, насиље и психотерапију како би Софију одбранио од удварача.",
      "image": "lib/assets/film2Slika.jpg"
    },
    {
      "name": "Orlovi rano lete",
      "trailer": "https://www.youtube.com/watch?v=RYasLjaJE24",
      "description": "Opis filma",
      "image": "lib/assets/film3Slika.jpg"
    },
    {
      "name": "Ivkova slava",
      "trailer": "https://www.youtube.com/watch?v=nsKEQkepliE",
      "description": "Opis filma",
      "image": "lib/assets/film4Slika.jpg"
    },
  ];
  final List<Map<String, dynamic>> _zaTebe = [
    {
      "name": "Ko to tamo peva",
      "description": "Opis filma",
      "image": "lib/assets/film1Slika.jpg"
    },
    {
      "name": "Mi nismo andjeli",
      "description": "Opis filma",
      "image": "lib/assets/film2Slika.jpg"
    },
    {
      "name": "Orlovi rano lete",
      "description": "Opis filma",
      "image": "lib/assets/film3Slika.jpg"
    },
    {
      "name": "Ivkova slava",
      "description": "Opis filma",
      "image": "lib/assets/film4Slika.jpg"
    },
  ];
  final List<Map<String, dynamic>> _novo = [
    {
      "name": "Ko to tamo peva",
      "description": "Opis filma",
      "image": "lib/assets/film1Slika.jpg"
    },
    {
      "name": "Mi nismo andjeli",
      "description": "Opis filma",
      "image": "lib/assets/film2Slika.jpg"
    },
    {
      "name": "Orlovi rano lete",
      "description": "Opis filma",
      "image": "lib/assets/film3Slika.jpg"
    },
    {
      "name": "Ivkova slava",
      "description": "Opis filma",
      "image": "lib/assets/film4Slika.jpg"
    },
  ];
  final List<Map<String, dynamic>> _akcija = [
    {
      "name": "Ko to tamo peva",
      "description": "Opis filma",
      "image": "lib/assets/film1Slika.jpg"
    },
    {
      "name": "Mi nismo andjeli",
      "description": "Opis filma",
      "image": "lib/assets/film2Slika.jpg"
    },
    {
      "name": "Orlovi rano lete",
      "description": "Opis filma",
      "image": "lib/assets/film3Slika.jpg"
    },
    {
      "name": "Ivkova slava",
      "description": "Opis filma",
      "image": "lib/assets/film4Slika.jpg"
    },
  ];
  // Map<String, dynamic> data = {
  //   "name": "John Smith",
  //   "email": "john@example.com"
  // };

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
                  ElevatedButton(
                    style: ButtonStyle(
                      backgroundColor:
                          MaterialStateProperty.all(Colors.grey[850]),
                      minimumSize:
                          MaterialStateProperty.all(const Size(10, 40)),
                    ),
                    onPressed: null,
                    child: Text("Filmovi",
                        style: Theme.of(context).textTheme.button),
                  ),
                  const SizedBox(
                    width: 15,
                  ),
                  ElevatedButton(
                    style: ButtonStyle(
                      backgroundColor:
                          MaterialStateProperty.all(Colors.grey[850]),
                      minimumSize:
                          MaterialStateProperty.all(const Size(10, 40)),
                    ),
                    onPressed: null,
                    child: Text("Serije",
                        style: Theme.of(context).textTheme.button),
                  )
                ],
              ),
              Expanded(
                child: ListView(
                  shrinkWrap: true,
                  children: [
                    MovieList("Najgledanije", _najgledanije),
                    MovieList("Za tebe", _zaTebe),
                    MovieList("Novo", _novo),
                    MovieList("Akcija", _akcija),
                  ],
                ),
              )
            ],
          )),
    );
  }
}
