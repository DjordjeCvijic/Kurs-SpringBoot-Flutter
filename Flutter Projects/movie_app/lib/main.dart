import 'package:flutter/material.dart';
import 'package:movie_app/screens/login_screen.dart';
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
            scaffoldBackgroundColor: Colors.grey[850]),
        home: const LoginScreen(),
        routes: {
          //globals.test_route: (ctx) => Test()
        });
  }
}
