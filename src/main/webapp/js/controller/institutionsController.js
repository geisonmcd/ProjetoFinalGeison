angular.module('institutions').controller("institutionsController", ["$scope", "$route", "institutions", "api",  function ($scope, $route, institutions, api){
    
    const init = function () {
        $scope.editMode = false;
        console.log(institutions);
        $scope.institutions = institutions.data;
        $scope.usuario = {};
    };
    
    $scope.saveInstitution = function (institution) {
        if (!institution) return;
        if (institution.idInstitution) {
            api.institutions.put($scope.institution.idInstitution, institution).then(function (response) {
                $route.reload();
            });
        } else {
            api.institutions.post(institution).then(function (response) {
                $route.reload();
            });
        }
    };

    $scope.deleteInstitution = function (institution) {
        api.institutions.delete(institution.idInstitution).then(function (response) {
            $route.reload();
        }, function (error){
        });
    };

    $scope.editInstitution = function (usuario) {
    console.log(usuario)
        $scope.editMode = true;
        $scope.usuario = angular.copy(usuario);
    }

    init();
}]);