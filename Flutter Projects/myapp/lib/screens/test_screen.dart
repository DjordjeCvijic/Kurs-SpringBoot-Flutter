import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:myapp/widget/login_button.dart';

class Test extends StatelessWidget {
  const Test({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final args =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>;
    void clickBackBtn() {
      Navigator.of(context).pop();
    }

    return Scaffold(
      body: Padding(
        child: Center(
          child: LoginButton(args["podatak"].toString(), clickBackBtn),
        ),
        padding: const EdgeInsets.fromLTRB(100, 100, 100, 110),
      ),
    );
  }
}
