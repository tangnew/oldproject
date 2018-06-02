/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-14
 *  Time: 13:04
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.question");
EXAM.modules.states.question = EXAM.extend(
    EXAM.modules.states.question,
    {
        home: {
            stateName: "main.question",
            stateConfig: {
                url: "/question",
                templateUrl: "components/question/tpl/home.html",
                controller: function ($state) {
                    $state.go(EXAM.modules.states.question.list.stateName);
                }
            }
        },
        list: {
            stateName: "main.question.list",
            stateConfig: {
                url: "/list",
                templateUrl: "components/question/tpl/list.html"
            }
        }
    }
);
