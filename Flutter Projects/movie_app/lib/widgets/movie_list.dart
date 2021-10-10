import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import "../globals.dart" as globals;

class MovieList extends StatelessWidget {
  const MovieList(this._kategorija, this._listaFilmova, {Key? key})
      : super(key: key);

  final String _kategorija;
  final List<Map<String, dynamic>> _listaFilmova;

  @override
  Widget build(BuildContext context) {
    clickOnContent(int i) {
      Navigator.of(context)
          .pushNamed(globals.content_description_screen_route, arguments: {
        "name": _listaFilmova[i]["name"],
        "trailer": _listaFilmova[i]["trailer"],
        "description": _listaFilmova[i]["description"]
      });
    }

    return Column(
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
                itemCount: 4,
                itemBuilder: (context, index) {
                  return InkWell(
                    child: Padding(
                      padding: EdgeInsets.all(8.0),
                      child: ClipRRect(
                        borderRadius: BorderRadius.circular(25),
                        child: Image(
                          // height: 200,
                          // width: 200,
                          image: AssetImage(
                            _listaFilmova[index]["image"],
                          ),
                        ),
                      ),
                    ),
                    onTap: () => clickOnContent(index),
                  );
                }),
          ),

          // child: ListView(
          //   scrollDirection: Axis.horizontal,
          //   shrinkWrap: true,
          //   children: [
          //     Padding(
          //       padding: EdgeInsets.all(8.0),
          //       child: ClipRRect(
          //         child: Image(
          //           // height: 200,
          //           // width: 200,
          //           image: AssetImage(_lista_filmova[0]["image"]),
          //         ),
          //       ),
          //     ),
          //     Padding(
          //       padding: EdgeInsets.all(8.0),
          //       child: ClipRRect(
          //         child: Image(
          //           // height: 200,
          //           // width: 200,
          //           image: AssetImage(_lista_filmova[1]["image"]),
          //         ),
          //       ),
          //     ),
          //     Padding(
          //       padding: EdgeInsets.all(8.0),
          //       child: ClipRRect(
          //         child: Image(
          //           // height: 200,
          //           // width: 200,
          //           image: AssetImage(_lista_filmova[2]["image"]),
          //         ),
          //       ),
          //     ),
          //     Padding(
          //       padding: EdgeInsets.all(8.0),
          //       child: ClipRRect(
          //         child: Image(
          //           // height: 200,
          //           // width: 200,
          //           image: AssetImage(_lista_filmova[3]["image"]),
          //         ),
          //       ),
          //     ),
          //   ],
          // ),
        ),
      ],
    );
  }
}
