import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';
import 'package:myapp/screens/login_screen.dart';
import 'package:myapp/screens/second_screen.dart';
import 'package:myapp/screens/test_screen.dart';
import "globals.dart" as globals;

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
            primarySwatch: Colors.green,
            buttonTheme: const ButtonThemeData(buttonColor: Colors.red),
            elevatedButtonTheme: ElevatedButtonThemeData(
                style: ButtonStyle(
                    backgroundColor: MaterialStateProperty.all(Colors.blue),
                    minimumSize: MaterialStateProperty.all(
                        const Size(double.infinity, 50)),
                    shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                        RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(28.0),
                    ))))),
        home: const LoginScreen(),
        routes: {
          globals.test_route: (ctx) => Test(),
          globals.second_screen_route: (ctx) => Home()
        });
  }
}
