var app = angular.module("UserManagement", []);
//Controller Part
app.controller("UserManagementController", function ($scope, $http) {

    //Initialize page with default data which is blank in this example
    $scope.employees = [];
    $scope.form = {
        id: -1,
        employeeName: "",
        salary: "",
        email: "",
        projectId: ""
    };

    //Now load the data from server
    _refreshPageData();

    //HTTP POST/PUT methods for add/edit employee
    $scope.submitEmployee = function () {

        var method = "";
        var url = "";
        if ($scope.form.id == -1) {
            //Id is absent so add employee - POST operation
            method = "POST";
            url = 'http://localhost:8080/DellService/webapi/employee/addEmployee';
        } else {
            //If Id is present, it's edit operation - PUT operation
            method = "PUT";
            url = 'http://localhost:8080/DellService/webapi/employee/updateEmployee' + $scope.form.id;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
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

});

