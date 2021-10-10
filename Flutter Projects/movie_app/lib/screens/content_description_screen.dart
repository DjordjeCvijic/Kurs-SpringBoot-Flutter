import 'package:flutter/material.dart';
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
              ],
            )));
  }
}
