/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-08
 *  Time: 18:05
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.login");
EXAM.modules.states.login = EXAM.extend(
    EXAM.modules.states.login,
    {
        home: {
            stateName: "index.login",
            stateConfig: {
                url: "/login",
                templateUrl: "components/login/tpl/login.html"
            }
        }
    }
);
