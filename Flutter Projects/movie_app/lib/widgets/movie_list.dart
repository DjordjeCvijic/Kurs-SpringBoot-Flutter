import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class MovieList extends StatelessWidget {
  MovieList(this.kategorija, {Key? key}) : super(key: key);
  String kategorija;
  @override
  Widget build(BuildContext context) {
    return Column(
      //crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const SizedBox(
          height: 50,
        ),
        Text(kategorija),
        const SizedBox(
          height: 20,
        ),
        SizedBox(
          height: 100,
          child: ListView(
            scrollDirection: Axis.horizontal,
            shrinkWrap: true,
            children: const [
              Padding(
                padding: EdgeInsets.all(8.0),
                child: ClipRRect(
                  child: Image(
                    // height: 200,
                    // width: 200,
                    image: AssetImage("lib/assets/image1.jpg"),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.all(8.0),
                child: ClipRRect(
                  child: Image(
                    // height: 200,
                    // width: 200,
                    image: AssetImage("lib/assets/image1.jpg"),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.all(8.0),
                child: ClipRRect(
                  child: Image(
                    // height: 200,
                    // width: 200,
                    image: AssetImage("lib/assets/image1.jpg"),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.all(8.0),
                child: ClipRRect(
                  child: Image(
                    // height: 200,
                    // width: 200,
                    image: AssetImage("lib/assets/image1.jpg"),
                  ),
                ),
              ),
            ],
          ),
        )
      ],
    );
  }
}
