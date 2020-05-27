var app = angular.module('app', []);
app.controller("CustomerCtrl", function ($scope, $http) {
    $scope.customers = [];
    $scope.customer = {
        id: "1",
        firstName: "Alex",
        lastName: "Ivanov",
        emailAddress: "test@mail.ru",
        address: "Санфирова д20",
        city: "Самара",
        country: "Россия",
        phoneNumber: "+788005553535",
        comment: ""
    };

    CustomerData()

    function CustomerData() {
        $http({
            method: 'GET',
            url: '/customers'
        }).then(
            function (res) { // success
                $scope.customers = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };
});