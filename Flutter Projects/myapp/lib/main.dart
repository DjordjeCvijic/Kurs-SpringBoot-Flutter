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
          appBar: AppBar(
            title: const Text("Naslov"),
          ),
          body: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Flexible(
                  flex: 1,
                  child: Container(
                    color: Colors.red,
                  )),
              Flexible(
                  flex: 3,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const Text(
                        "Login",
                        style: TextStyle(
                            fontSize: 30, fontWeight: FontWeight.bold),
                      ),
                      const SizedBox(height: 10),
                      const Text(
                        "Email",
                        style: TextStyle(
                            fontSize: 18, fontWeight: FontWeight.bold),
                      ),
                      TextField(
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
                            fontSize: 18, fontWeight: FontWeight.bold),
                      ),
                      TextField(
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
                              onPressed: _controller.clear,
                              icon: const Icon(Icons.visibility)),
                        ),
                      ),
                      const SizedBox(height: 3),
                      RichText(
                        text: TextSpan(children: [
                          TextSpan(
                              text: "Forgot password ?",
                              style: const TextStyle(fontSize: 8),
                              recognizer: TapGestureRecognizer()
                                ..onTap = () {
                                  print('Forgot password Clicked');
                                }),
                        ]),
                      ),
                    ],
                  )),
              Flexible(
                  flex: 1,
                  child: Container(
                    color: Colors.green,
                  ))
            ],
          ),
        ));
  }
}
