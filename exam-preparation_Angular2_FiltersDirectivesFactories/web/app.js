var app = angular.module('examApp', []);

app.controller('Controller', ['Factory', function (Factory) {
        var self = this;
        self.title = "exam-preparation_Angular2_FiltersDirectivesFactories.pdf";
        self.studentsInfo = Factory.studentsInfo;
    }]);

app.factory('Factory', [function () {
        var studentsInfo = {};
        studentsInfo.allCourses = [
            {courseId: 1000, courseName: "Basic Programming"},
            {courseId: 1001, courseName: "Advanced Programming"},
            {courseId: 1003, courseName: "DataBase Intro"}];

        studentsInfo.students = [
            {studentId: 100, name: "Peter Hansen", grades: [{grade: "10"}, {grade: "12"}, {}]},
            {studentId: 101, name: "Jan Olsen", grades: [{grade: "7"}, {grade: "10"}, {}]},
            {studentId: 102, name: "Gitte Poulsen", grades: [{grade: "7"}, {grade: "7"}, {}]},
            {studentId: 103, name: "John McDonald", grades: [{grade: "10"}, {}, {grade: "7"}]}
        ];
        return {
            studentsInfo: studentsInfo
        };
    }]);

app.filter('AverageFilter', function () {
    return function (input) {
        var avg = 0;
        for (var i = 0; i < input.length; i++) {
            if (input[i].grade == undefined) {
                avg += 0;
            } else {
                avg += parseInt(input[i].grade);
            }
        }

        return parseInt(avg / input.length);
    };
});

app.directive('studentGrades', function () {
    return {
        templateUrl: 'partials/gradesTable.html'
    };
});