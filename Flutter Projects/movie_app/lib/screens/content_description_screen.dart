import 'package:flutter/material.dart';
import 'package:movie_app/widgets/comment.dart';
import 'package:youtube_player_flutter/youtube_player_flutter.dart';

class ContentDescriptionScreen extends StatelessWidget {
  const ContentDescriptionScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final args =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>;

    final YoutubePlayerController _controller = YoutubePlayerController(
      initialVideoId: YoutubePlayer.convertUrlToId(args["trailer"]),
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
                args["name"],
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
                args["description"],
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 20,
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
                itemCount: _uloge.length,
                itemBuilder: (context, index) {
                  final _ime = _uloge[index]['ime'];
                  final _uloga = _uloge[index]['uloga'];
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
              ListView.builder(
                physics: const NeverScrollableScrollPhysics(),
                shrinkWrap: true,
                itemCount: _uloge.length,
                itemBuilder: (context, index) {
                  String _ime = _komentari[index]['ime'].toString();
                  int _zvjezdice = _komentari[index]['zvjezdice'];
                  String _komentar = _komentari[index]['komentar'].toString();
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Comment(_ime, _zvjezdice, _komentar),
                  );
                },
              ),
            ],
          ),
        ));
  }
}
