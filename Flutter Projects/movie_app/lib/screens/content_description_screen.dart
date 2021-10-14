import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:movie_app/helpers/token.dart';
import 'package:movie_app/providers/content_provider.dart';
import 'package:movie_app/widgets/comment.dart';
import 'package:provider/provider.dart';
import 'package:youtube_player_flutter/youtube_player_flutter.dart';

class ContentDescriptionScreen extends StatefulWidget {
  const ContentDescriptionScreen({Key? key}) : super(key: key);

  @override
  State<ContentDescriptionScreen> createState() =>
      _ContentDescriptionScreenState();
}

class _ContentDescriptionScreenState extends State<ContentDescriptionScreen> {
  @override
  Widget build(BuildContext context) {
    final args =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>;
    final contentDetails = args["data"] as Map<String, dynamic>;
    final contentId = args["contentId"] as int;

    List<dynamic> comments = contentDetails["contentComments"] as List<dynamic>;
    var textEditingController = TextEditingController();

    final YoutubePlayerController _controller = YoutubePlayerController(
      initialVideoId: contentDetails["trailerLink"],
      //initialVideoId: 'iLnmTe5Q2Qw',
      flags: const YoutubePlayerFlags(
        autoPlay: false,
        mute: true,
      ),
    );

    List<Map<String, String>> _uloge = [
      {"ime": "Nikola Kojo", "uloga": "Nikola"},
      {"ime": "Milena Pavlvoic", "uloga": "Marina"},
      {"ime": "Branka Katic", "uloga": "Buba"},
      {"ime": "Nikola Kojo", "uloga": "Nikola"},
      {"ime": "Milena Pavlvoic", "uloga": "Marina"},
      {"ime": "Branka Katic", "uloga": "Buba"},
    ];
    List<Map<String, dynamic>> _komentari = [
      {"ime": "Nikola Kojo", "zvjezdice": 1, "komentar": "komentar"},
      {"ime": "Milena Pavlvoic", "zvjezdice": 2, "komentar": "komentar"},
      {"ime": "Branka Katic", "zvjezdice": 3, "komentar": "komentar"},
      {"ime": "Nikola Kojo", "zvjezdice": 3, "komentar": "komentar"},
      {"ime": "Milena Pavlvoic", "zvjezdice": 4, "komentar": "komentar"},
      {"ime": "Branka Katic", "zvjezdice": 2, "komentar": "komentar"},
    ];

    return Scaffold(
        appBar: AppBar(
          title: const Text(
            "Opis",
            style: TextStyle(
              color: Colors.white,
              fontSize: 40,
            ),
          ),
          centerTitle: true,
          toolbarHeight: 60,
          backgroundColor: Theme.of(context).scaffoldBackgroundColor,
          leading: IconButton(
            iconSize: 35,
            focusColor: Colors.white,
            icon: const Icon(
              Icons.arrow_back,
              color: Colors.white,
            ),
            onPressed: () => Navigator.of(context).pop(),
          ),
        ),
        body: Padding(
          padding: const EdgeInsets.fromLTRB(20, 30, 20, 0),
          child: ListView(
            children: [
              Text(
                contentDetails["title"],
                style: TextStyle(
                  color: Colors.grey[400],
                  fontSize: 65,
                ),
                textAlign: TextAlign.center,
              ),
              const SizedBox(
                height: 25,
              ),
              YoutubePlayer(
                controller: _controller,
                liveUIColor: Colors.amber,
              ),
              const SizedBox(
                height: 20,
              ),
              Text(
                "Trajanje: ${contentDetails['duration']} minuta",
                style: Theme.of(context).textTheme.subtitle1,
              ),
              const SizedBox(
                height: 5,
              ),
              Text(
                "Godina izdavanja: ${contentDetails['year']}",
                style: Theme.of(context).textTheme.subtitle1,
              ),
              const SizedBox(
                height: 5,
              ),
              Text(
                "Žanrovi:",
                style: Theme.of(context).textTheme.subtitle1,
              ),
              Container(
                padding: const EdgeInsets.only(left: 10),
                height: 50,
                child: ListView.builder(
                  physics: const NeverScrollableScrollPhysics(),
                  itemCount: contentDetails['genres'].length,
                  itemBuilder: (context, index) => Text(
                    '- ${contentDetails['genres'][index]['name']}',
                    style: Theme.of(context).textTheme.subtitle2,
                  ),
                ),
              ),
              const SizedBox(
                height: 20,
              ),
              const Text(
                "Uloge:",
                style: TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                  fontSize: 25,
                ),
              ),
              ListView.builder(
                physics: const NeverScrollableScrollPhysics(),
                shrinkWrap: true,
                itemCount:
                    (contentDetails["movieCastList"] as List<dynamic>).length,
                itemBuilder: (context, index) {
                  final _ime = (contentDetails["movieCastList"][index]
                      ["moviePeople"]["firstName"]);
                  final _uloga = (contentDetails["movieCastList"][index]
                      ["movieRole"]["name"]);
                  return Text(
                    _ime.toString() + " - " + _uloga.toString(),
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 20,
                    ),
                  );
                },
              ),
              Row(children: [
                Expanded(
                  child: Container(
                      margin: const EdgeInsets.only(right: 20.0),
                      child: const Divider(
                        color: Colors.white,
                        height: 36,
                      )),
                ),
                const Text(
                  "Komentari",
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                  ),
                ),
                Expanded(
                  child: Container(
                      margin: const EdgeInsets.only(
                        left: 20.0,
                      ),
                      child: const Divider(
                        color: Colors.white,
                        height: 36,
                      )),
                ),
              ]),
              ChangeNotifierProvider.value(
                value: ContentProvider(),
                builder: (context, child) => Column(
                  children: [
                    ListView.builder(
                      physics: const NeverScrollableScrollPhysics(),
                      shrinkWrap: true,
                      itemCount: contentDetails["contentComments"].length,
                      itemBuilder: (context, index) {
                        String _ime = contentDetails["contentComments"][index]
                            ["user"]["firstName"];
                        // int _zvjezdice = _komentari[index]['zvjezdice'];
                        int _zvjezdice = 3;
                        String _komentar =
                            contentDetails["contentComments"][index]["comment"];
                        return Padding(
                          padding: const EdgeInsets.all(8.0),
                          child: Comment(_ime, _zvjezdice, _komentar),
                        );
                      },
                    ),
                    Column(
                      children: [
                        SizedBox(
                          height: 20,
                        ),
                        TextField(
                          style: TextStyle(color: Colors.black),
                          cursorColor: Colors.black,
                          controller: textEditingController,
                          decoration: InputDecoration(
                            filled: true,
                            fillColor: Colors.grey.shade300,
                            focusedBorder: const OutlineInputBorder(
                                borderRadius:
                                    BorderRadius.all(Radius.circular(11.0))),
                            enabledBorder: const OutlineInputBorder(
                                borderSide: BorderSide(color: Colors.white),
                                borderRadius:
                                    BorderRadius.all(Radius.circular(11.0))),
                            hintText: 'Komment',
                            hintStyle: const TextStyle(fontSize: 12),
                          ),
                        ),
                        SizedBox(
                          height: 20,
                        ),
                        ElevatedButton(
                            onPressed: () {
                              final contentProvider =
                                  Provider.of<ContentProvider>(context,
                                      listen: false);

                              contentProvider.addComment(
                                  8, contentId, textEditingController.text);
                            },
                            child: Text("Dodaj komentar"),
                            style: ButtonStyle(
                                backgroundColor:
                                    MaterialStateProperty.all(Colors.blue),
                                minimumSize: MaterialStateProperty.all(
                                    const Size(double.infinity, 60)),
                                shape: MaterialStateProperty.all<
                                        RoundedRectangleBorder>(
                                    RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(28.0),
                                )))),
                      ],
                    )
                  ],
                ),
              ),
            ],
          ),
        ));
  }
}
