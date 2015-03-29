var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":17,"id":16,"methods":[{"el":10,"sc":5,"sl":8},{"el":13,"sc":5,"sl":11},{"el":16,"sc":5,"sl":14}],"name":"Concatenator","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":8}],"name":"testConcatenate","pass":true,"statements":[{"sl":9}]},"test_1":{"methods":[{"sl":8}],"name":"testConcatenate","pass":true,"statements":[{"sl":9}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [0, 1], [0, 1], [], [], [], [], [], [], [], []]
