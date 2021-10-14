import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:movie_app/providers/content_provider.dart';
import 'package:provider/provider.dart';
import "../globals.dart" as globals;

class MovieList extends StatelessWidget {
  const MovieList(this._kategorija, this._listaFilmova, {Key? key})
      : super(key: key);

  final List<Map<String, dynamic>>? _listaFilmova;
  final String _kategorija;

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider.value(
      value: ContentProvider(),
      builder: (context, child) => Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const SizedBox(
            height: 30,
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(10, 0, 0, 0),
            child: Text(
              _kategorija,
              style: TextStyle(color: Colors.grey[400], fontSize: 25),
            ),
          ),
          const SizedBox(
            height: 10,
          ),
          SizedBox(
            height: 230,
            child: Container(
              padding: const EdgeInsets.all(8.0),
              decoration: BoxDecoration(
                borderRadius: BorderRadius.circular(20),
                color: Colors.grey[800],
              ),
              child: ListView.builder(
                  scrollDirection: Axis.horizontal,
                  itemCount: _listaFilmova!.length,
                  itemBuilder: (context, index) {
                    return InkWell(
                        child: Padding(
                          padding: EdgeInsets.all(8.0),
                          child: Container(
                              decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(20)),
                              child: Image.network(
                                  (_listaFilmova![index])["coverLink"],
                                  fit: BoxFit.contain)),
                        ),
                        onTap: () {
                          Provider.of<ContentProvider>(context, listen: false)
                              .getContentDetails(
                                  (_listaFilmova![index])["contentId"])
                              .then((value) {
                            Navigator.of(context).pushNamed(
                                globals.content_description_screen_route,
                                arguments: {
                                  "data": value,
                                  "contentId": _listaFilmova![index]
                                      ["contentId"]
                                });
                          });
                        });
                  }),
            ),
          ),
        ],
      ),
    );
  }
}
