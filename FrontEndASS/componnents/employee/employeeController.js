var app = angular.module("UserManagement", []);
//Controller Part
app.controller("UserManagementController", function ($scope, $http) {

    //Initialize page with default data which is blank in this example
    $scope.employees = [];
    $scope.form = {
        id: "",
        employeeName: "",
        salary: "",
        email: "",
        projectId: ""
    };

    //Now load the data from server
    _refreshPageData();

    
    $scope.project = [];
    $scope.form = {
        pId: "",
        pName: ""
    };
 
    //HTTP POST methods for add employee
    $scope.submitEmployee = function () {

        $http({
            method: "POST",
            url: "http://localhost:8080/DellService/webapi/employee/addEmployee",
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }

        })
        alert("employee added");
    };

    //In case of edit employee, populate form with employee data
    $scope.editEmployee = function (employee) {
        $scope.form.employeeName = employee.employeeName;
        $scope.form.salary = employee.salary;
        $scope.form.email = employee.email;
        $scope.form.projectId = employee.projectId.id;
        $scope.form.id = employee.id;
    };

    //HTTP PUT methods for add/edit employee
    $scope.updateEmployee = function () {

        $http({
            method: "PUT",
            url: 'http://localhost:8080/DellService/webapi/employee/updateEmployee' + "/" + $scope.form.id,
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }
        })
    };

    /* Private Methods */
    //HTTP GET- get all employees collection
    function _refreshPageData() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/DellService/webapi/employee/getAllEmployee'
        }).then(function successCallback(response) {

            $scope.employee = response.data;
            //console.log(response.data);

        }, function errorCallback(response) {
            console.log(response.statusText);

        });
    }

    //HTTP DELETE- delete employee by Id
    $scope.removeEmployee = function (employee) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/DellService/webapi/employee/deleteEmployee' + "/" + $scope.employee.id

        })
    };

    /* Private Methods */
    //HTTP GET- get all project collection
    $scope.getProjectDetails = function (project) {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/DellService/webapi/project/getAllProjects'
        }).then(function successCallback(response) {

            $scope.project = response.data1;
            console.log(response.data1);

        }, function errorCallback(response) {
            console.log(response.statusText);

        });
    }

});

