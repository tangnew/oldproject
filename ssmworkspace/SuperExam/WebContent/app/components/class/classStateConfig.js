/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-14
 *  Time: 10:04
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.class");
EXAM.modules.states.class = EXAM.extend(
    EXAM.modules.states.class,
    {
        home: {
            stateName: "main.class",
            stateConfig: {
                url: "/class",
                templateUrl: "components/class/tpl/home.html",
                controller: function ($state) {
                    $state.go(EXAM.modules.states.class.list.stateName);
                }
            }
        },
        list: {
            stateName: "main.class.list",
            stateConfig: {
                url: "/list",
                templateUrl: "components/class/tpl/list.html"
            }
        }
    }
);
