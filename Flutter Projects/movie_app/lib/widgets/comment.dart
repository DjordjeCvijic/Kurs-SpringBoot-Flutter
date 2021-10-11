import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';

class Comment extends StatelessWidget {
  const Comment(this._ime, this._zvjezdice, this._komentar, {Key? key})
      : super(key: key);
  final String _ime;
  final int _zvjezdice;
  final String _komentar;
  @override
  Widget build(BuildContext context) {
    return Container(
      // height: 20,
      padding: const EdgeInsets.all(8.0),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(20),
        color: Colors.white,
      ),
      child: Column(crossAxisAlignment: CrossAxisAlignment.start, children: [
        Row(
          children: [
            Expanded(
              child: Text(
                _ime,
                style: TextStyle(color: Colors.black, fontSize: 20),
              ),
            ),
            // Text(_zvjezdice,
            //     style: TextStyle(color: Colors.white, fontSize: 20))
            RatingBar.builder(
                itemBuilder: (context, _) => const Icon(
                      Icons.star,
                      color: Colors.amber,
                    ),
                ignoreGestures: true,
                itemSize: 20,
                initialRating: _zvjezdice.toDouble(),
                direction: Axis.horizontal,
                onRatingUpdate: (a) => {})
          ],
        ),
        SizedBox(
          height: 20,
        ),
        Text(_komentar, style: TextStyle(color: Colors.grey, fontSize: 20)),
        SizedBox(
          height: 9,
        ),
      ]),
    );
  }
}
