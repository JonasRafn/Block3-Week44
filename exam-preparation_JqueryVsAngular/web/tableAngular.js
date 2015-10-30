var app = angular.module("examApp", []);

app.controller("ExamController", ['$http', function ($http) {
        var self = this;
        self.title = "Angular table";
        $http.get("http://localhost:8080/AngularJQuery/api/members").then(function (res) {
            self.members = res.data;
        });
    }]);