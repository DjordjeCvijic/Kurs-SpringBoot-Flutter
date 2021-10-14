import 'package:flutter/material.dart';

class SimpleTab extends StatelessWidget {
  final bool active;
  final String? tabTitle;
  final Function? onTap;

  const SimpleTab({
    Key? key,
    this.active = false,
    @required this.tabTitle,
    @required this.onTap,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return InkWell(
      onTap: () => onTap!(),
      child: Container(
        decoration: active
            ? const BoxDecoration(
                border: BorderDirectional(
                  bottom: BorderSide(
                    width: 1,
                    color: Colors.white,
                  ),
                ),
              )
            : null,
        child: Text(
          tabTitle ?? "",
          style: active ? theme.textTheme.bodyText1 : theme.textTheme.bodyText2,
        ),
      ),
    );
  }
}
