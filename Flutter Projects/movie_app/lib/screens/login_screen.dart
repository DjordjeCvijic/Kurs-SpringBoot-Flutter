import 'package:flutter/material.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
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
              onPressed: null,
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
        padding: const EdgeInsets.fromLTRB(60, 20, 60, 0),
      ),
    );
  }
}
