import 'package:flutter/material.dart';

class LoginButton extends StatelessWidget {
  const LoginButton(this.mess, this.onTapFunction, {Key? key})
      : super(key: key);

  final String mess;
  final Function onTapFunction;
  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        // style: ButtonStyle(
        //     backgroundColor: MaterialStateProperty.all(Colors.blue),
        //     minimumSize:
        //         MaterialStateProperty.all(const Size(double.infinity, 50)),
        //     shape: MaterialStateProperty.all<RoundedRectangleBorder>(
        //         RoundedRectangleBorder(
        //       borderRadius: BorderRadius.circular(28.0),
        //     ))),
        onPressed: () {
          onTapFunction();
        },
        child: Text(mess,
            style: const TextStyle(
              fontSize: 20.0,
            )));
  }
}
