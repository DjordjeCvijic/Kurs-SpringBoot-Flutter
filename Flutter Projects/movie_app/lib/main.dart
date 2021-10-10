import 'package:flutter/material.dart';
import 'package:movie_app/screens/content_description_screen.dart';
import 'package:movie_app/screens/login_screen.dart';
import 'package:movie_app/screens/main_screen.dart';
import "globals.dart" as globals;

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
            primarySwatch: Colors.blue,
            scaffoldBackgroundColor: Colors.grey[900],
            elevatedButtonTheme: ElevatedButtonThemeData(
                style: ButtonStyle(
                    backgroundColor:
                        MaterialStateProperty.all(Colors.grey[900]),
                    minimumSize: MaterialStateProperty.all(const Size(10, 60)),
                    shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                        RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(28.0),
                            side: const BorderSide(
                              width: 0.5,
                              style: BorderStyle.solid,
                              color: Colors.white,
                            ))))),
            textTheme: const TextTheme(
                button: TextStyle(
              fontSize: 25,
              color: Colors.white,
            ))),
        home: const LoginScreen(),
        routes: {
          globals.main_screen_route: (ctx) => const MainScreen(),
          globals.content_description_screen_route: (ctx) =>
              ContentDescriptionScreen()
        });
  }
}
