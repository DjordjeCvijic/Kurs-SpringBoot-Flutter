import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var _controller = TextEditingController();

    return MaterialApp(
        title: 'Flutter Demo',
        theme: ThemeData(
            primarySwatch: Colors.green,
            buttonTheme: const ButtonThemeData(buttonColor: Colors.red)),
        home: Scaffold(
          backgroundColor: Colors.grey[850],
          body: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Flexible(flex: 1, child: Container()),
              Flexible(
                  flex: 3,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text(
                        "Login",
                        style: TextStyle(
                            fontSize: 50,
                            fontWeight: FontWeight.bold,
                            color: Colors.white),
                      ),
                      const SizedBox(height: 20),
                      const Text(
                        "Email",
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.white),
                      ),
                      const SizedBox(height: 7),
                      TextField(
                        cursorColor: Colors.black,
                        decoration: InputDecoration(
                            filled: true,
                            fillColor: Colors.grey.shade300,
                            focusedBorder: const OutlineInputBorder(
                              borderRadius:
                                  BorderRadius.all(Radius.circular(11.0)),
                            ),
                            enabledBorder: const OutlineInputBorder(
                              borderSide: BorderSide(color: Colors.white),
                              borderRadius:
                                  BorderRadius.all(Radius.circular(11.0)),
                            ),
                            hintText: 'Email',
                            hintStyle: const TextStyle(fontSize: 12)),
                      ),
                      const SizedBox(height: 30),
                      const Text(
                        "Password",
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.white),
                      ),
                      const SizedBox(height: 7),
                      TextField(
                        cursorColor: Colors.black,
                        controller: _controller,
                        decoration: InputDecoration(
                          filled: true,
                          fillColor: Colors.grey.shade300,
                          focusedBorder: const OutlineInputBorder(
                              borderRadius:
                                  BorderRadius.all(Radius.circular(11.0))),
                          enabledBorder: const OutlineInputBorder(
                              borderSide: BorderSide(color: Colors.white),
                              borderRadius:
                                  BorderRadius.all(Radius.circular(11.0))),
                          hintText: 'Password',
                          hintStyle: const TextStyle(fontSize: 12),
                          suffixIcon: IconButton(
                              color: Colors.black,
                              onPressed: _controller.clear,
                              icon: const Icon(Icons.visibility)),
                        ),
                      ),
                      const SizedBox(height: 8),
                      RichText(
                        text: TextSpan(children: [
                          TextSpan(
                              text: "Forgot passweord ?",
                              style: const TextStyle(
                                  fontSize: 10, color: Colors.white),
                              recognizer: TapGestureRecognizer()
                                ..onTap = () {
                                  print('Forgot password Clicked');
                                }),
                        ]),
                      ),
                      const SizedBox(height: 20),
                      ElevatedButton(
                          style: ButtonStyle(
                              backgroundColor:
                                  MaterialStateProperty.all(Colors.blue),
                              minimumSize: MaterialStateProperty.all(
                                  const Size(double.infinity, 50)),
                              shape: MaterialStateProperty.all<
                                      RoundedRectangleBorder>(
                                  RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(28.0),
                              ))),
                          onPressed: () {
                            print("Login Button ");
                          },
                          child: const Text('Log in',
                              style: TextStyle(
                                fontSize: 20.0,
                              )))
                    ],
                  )),
              Flexible(flex: 1, child: Container())
            ],
          ),
        ));
  }
}
