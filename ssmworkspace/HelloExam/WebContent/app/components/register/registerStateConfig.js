/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-09
 *  Time: 15:21
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.register");
EXAM.modules.states.register = EXAM.extend(
    EXAM.modules.states.register,
    {
        home: {
            stateName: "index.register",
            stateConfig: {
                url: "/register",
                templateUrl: "components/register/tpl/register.html"
            }
        }
    }
);
