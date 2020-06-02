var user = angular.module('user', []);
user.controller("UserCtrl", function ($scope, $http, UserService) {
    $scope.users = [];
    $scope.user = {
        id:"1",
        username:"Alex",
        role:"USER"};
    UserData()

    function UserData() {
        $http({
            method: 'GET',
            url: '/user'
        }).then(
            function (res) { // success
                $scope.users = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };


    $scope.updateUser = function () {
        UserService.updateUser($scope.user.id)
            .then(function success(response) {
                    $scope.message = 'User data updated!';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.errorMessage = 'Error updating user!';
                    $scope.message = '';
                });
        UserData()
    }

    $scope.getUser = function () {
        var id = $scope.user.id;
        UserService.getUser($scope.user.id)
            .then(function success(response) {
                    $scope.user = response.data;
                    $scope.user.id = id;
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response) {
                    $scope.message = '';
                    if (response.status === 404) {
                        $scope.errorMessage = 'User not found!';
                    } else {
                        $scope.errorMessage = "Error getting user!";
                    }
                });
        UserData()
    }


});
user.service('UserService', ['$http', function ($http) {

    this.getUser = function getUser(id) {
        return $http({
            method: 'GET',
            url: '/user/' + id
        });
    }


    this.updateUser = function updateUser( id) {
        return $http({
            method: 'PUT',
            url: '/user/' + id,
            data: {
                id:id,
            }
        })
    }
}]);