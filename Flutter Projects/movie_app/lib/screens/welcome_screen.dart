import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:movie_app/helpers/token.dart';
import 'package:movie_app/providers/login_provider.dart';
import 'package:provider/provider.dart';

import "../globals.dart" as globals;

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // void clickOnSingInBtn() {
    //   Navigator.pushNamed(
    //     context,
    //     globals.login_route,
    //   );
    // }

    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.fromLTRB(40, 20, 40, 0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(35),
              child: const Image(
                image: AssetImage("lib/assets/image1.jpg"),
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              "Svi filmovi na jednom mjestu!",
              style: TextStyle(
                  fontSize: 53,
                  fontWeight: FontWeight.bold,
                  color: Colors.white),
            ),
            const SizedBox(height: 100),
            ElevatedButton(
              onPressed: () async {
                if (await Token.getJwtToken() == null) {
                  Navigator.of(context).pushNamed(globals.login_route);
                } else {
                  Navigator.of(context).pushNamed(globals.main_screen_route);
                }

                // Provider.of<LoginPovider>(context, listen: false)
                //     .getJwtToken()
                //     .then((value) {
                //   if (value != null) {
                //     log("ima token");
                //     Navigator.of(context).pushNamed(globals.main_screen_route);
                //   } else {
                //     log("nema token");
                //     Navigator.of(context).pushNamed(globals.login_route);
                //   }
                // });

                //         FutureBuilder(
                //   future: Token.getJwtToken(),
                //   builder: (ctx, snapshot) =>
                //       snapshot.connectionState == ConnectionState.waiting
                //           ? const Center(
                //               child: CircularProgressIndicator(),
                //             )
                //           : snapshot.data != null
                //               ? Navigator.of(context).pushNamed(globals.main_screen_route)
                //               : Navigator.of(context).pushNamed(globals.login_route),
                // ),
              },
              child: Text("Sing in with Email",
                  style: Theme.of(context).textTheme.button),
              style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all(Colors.blue),
                  minimumSize: MaterialStateProperty.all(
                      const Size(double.infinity, 60)),
                  shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                      RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(28.0),
                  ))),
            ),
            const SizedBox(
              height: 20,
            ),
            Row(
              children: [
                Expanded(
                    child: ElevatedButton(
                  onPressed: null,
                  child:
                      Text("Google", style: Theme.of(context).textTheme.button),
                )),
                const SizedBox(
                  width: 35,
                ),
                Expanded(
                    child: ElevatedButton(
                  onPressed: null,
                  child: Text("Apple ID",
                      style: Theme.of(context).textTheme.button),
                ))
              ],
            )
          ],
        ),
      ),
    );
  }
}
