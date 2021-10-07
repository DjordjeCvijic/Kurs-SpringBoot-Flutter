import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:myapp/widget/login_button.dart';
import "../globals.dart" as globals;

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    void clickOnLoginBtn() {
      Navigator.of(context).pushNamed(globals.second_screen_route,
          arguments: {"podatak": "nesto"});
    }

    return Scaffold(
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
                          borderRadius: BorderRadius.all(Radius.circular(11.0)),
                        ),
                        enabledBorder: const OutlineInputBorder(
                          borderSide: BorderSide(color: Colors.white),
                          borderRadius: BorderRadius.all(Radius.circular(11.0)),
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
                    controller: null,
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
                      suffixIcon: const IconButton(
                          color: Colors.black,
                          onPressed: null,
                          icon: Icon(Icons.visibility)),
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
                  LoginButton("Login", clickOnLoginBtn)
                ],
              )),
          Flexible(flex: 1, child: Container())
        ],
      ),
    );
  }
}
