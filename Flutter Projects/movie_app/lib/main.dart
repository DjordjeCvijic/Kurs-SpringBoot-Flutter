import 'package:flutter/material.dart';
import 'package:movie_app/providers/login_provider.dart';
import 'package:movie_app/screens/content_description_screen.dart';
import 'package:movie_app/screens/login_screen.dart';
import 'package:movie_app/screens/welcome_screen.dart';
import 'package:movie_app/screens/main_screen.dart';
import 'package:provider/provider.dart';
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
                headline1: TextStyle(
                  color: Colors.white,
                  fontSize: 40,
                  fontWeight: FontWeight.bold,
                ),
                headline2: TextStyle(
                  color: Colors.white,
                  fontSize: 35,
                  fontWeight: FontWeight.w300,
                ),
                subtitle2: TextStyle(
                  color: Color.fromRGBO(
                    193,
                    193,
                    193,
                    1,
                  ),
                  fontSize: 13,
                  fontWeight: FontWeight.w500,
                ),
                subtitle1: TextStyle(
                  color: Color.fromRGBO(
                    193,
                    193,
                    193,
                    1,
                  ),
                  fontSize: 15,
                  fontWeight: FontWeight.w500,
                ),
                caption: TextStyle(
                  color: Colors.black,
                  fontSize: 15,
                  fontWeight: FontWeight.w500,
                ),
                bodyText1: TextStyle(
                  color: Colors.white,
                  fontSize: 20,
                  fontWeight: FontWeight.w500,
                ),
                bodyText2: TextStyle(
                  color: Color.fromRGBO(
                    193,
                    193,
                    193,
                    1,
                  ),
                  fontSize: 20,
                  fontWeight: FontWeight.w300,
                ),
                button: TextStyle(
                  fontSize: 25,
                  color: Colors.white,
                ))),
        home: ChangeNotifierProvider(
          create: (context) => LoginPovider(),
          child: const WelcomeScreen(),
        ),
        //home: const WelcomeScreen(),
        routes: {
          globals.main_screen_route: (ctx) => const MainScreen(),
          globals.login_route: (ctx) => const LoginScreen(),
          globals.content_description_screen_route: (ctx) =>
              ContentDescriptionScreen()
        });
  }
}
