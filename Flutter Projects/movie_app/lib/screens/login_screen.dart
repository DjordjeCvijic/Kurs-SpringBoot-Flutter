import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:movie_app/providers/login_provider.dart';
import 'package:provider/provider.dart';
import "../globals.dart" as globals;

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var _emailController = TextEditingController();
    var _passController = TextEditingController();
    final args =
        ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>;
    void clickOnLoginBtn() {
      Navigator.of(context).pushNamed(globals.main_screen_route,
          arguments: {"podatak": "nesto"});
    }

    return ChangeNotifierProvider(
      create: (context) => LoginPovider(),
      child: Scaffold(
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
                    TextFormField(
                      controller: _emailController,
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
                    TextFormField(
                      cursorColor: Colors.black,
                      controller: _passController,
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
                    Consumer<LoginPovider>(
                        builder: (context, loginProvide, child) =>
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
                                onPressed: () async {
                                  loginProvide
                                      .login(_emailController.text,
                                          _passController.text)
                                      .then((value) {
                                    if (value) {
                                      //Navigator.of(context).pop();
                                      Navigator.pushReplacementNamed(
                                          context, globals.main_screen_route);
                                    } else {
                                      showDialog(
                                        context: context,
                                        builder: (_) => AlertDialog(
                                          title: const Text('Pažnja!'),
                                          content: const Text(
                                              'Došlo je do greške prilikom prijave, provjerite kredencijale i pokušajte ponovo.'),
                                          actions: [
                                            TextButton(
                                              onPressed: () {
                                                Navigator.of(context).pop();
                                              },
                                              child: const Text('OK'),
                                            ),
                                          ],
                                        ),
                                      );
                                    }
                                  });
                                },
                                child: Text("Login",
                                    style: const TextStyle(
                                      fontSize: 20.0,
                                    )))),
                    // ElevatedButton(
                    //     style: ButtonStyle(
                    //         backgroundColor:
                    //             MaterialStateProperty.all(Colors.blue),
                    //         minimumSize: MaterialStateProperty.all(
                    //             const Size(double.infinity, 50)),
                    //         shape: MaterialStateProperty.all<
                    //             RoundedRectangleBorder>(RoundedRectangleBorder(
                    //           borderRadius: BorderRadius.circular(28.0),
                    //         ))),
                    //     onPressed: () async {
                    //       Provider.of<LoginPovider>(context, listen: false)
                    //           .login(
                    //               _emailController.text, _passController.text)
                    //           .then((value) {
                    //         if (value) {
                    //           Navigator.of(context).pushReplacementNamed(
                    //               globals.main_screen_route);
                    //         } else {
                    //           showDialog(
                    //             context: context,
                    //             builder: (_) => AlertDialog(
                    //               title: const Text('Pažnja!'),
                    //               content: const Text(
                    //                   'Došlo je do greške prilikom prijave, provjerite kredencijale i pokušajte ponovo.'),
                    //               actions: [
                    //                 TextButton(
                    //                   onPressed: () {
                    //                     Navigator.of(context).pop();
                    //                   },
                    //                   child: const Text('OK'),
                    //                 ),
                    //               ],
                    //             ),
                    //           );
                    //         }
                    //       });
                    //     },
                    //     child: Text("Login",
                    //         style: const TextStyle(
                    //           fontSize: 20.0,
                    //         )))
                  ],
                )),
            Flexible(flex: 1, child: Container())
          ],
        ),
      ),
    );
  }
}
