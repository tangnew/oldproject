/**
 *  Created by JW
 *  User: JW
 *  Date: 2016-11-11
 *  Time: 15:30
 *  Description:
 */
EXAM.namespace("EXAM.modules.states.main");
EXAM.modules.states.main = EXAM.extend(
    EXAM.modules.states.main,
    {
        home: {
            stateName: "main",
            stateConfig: {
                url: "/main",
                template: "<div ui-view></div>",
                abstract:true
            }
        }
    }
);
