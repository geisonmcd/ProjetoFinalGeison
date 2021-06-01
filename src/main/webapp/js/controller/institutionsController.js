angular.module('institutions').controller("institutionsController", ["$scope", "$route", "institutions", "api",  function ($scope, $route, institutions, api){
    
    const init = function () {
        $scope.editMode = false;
        console.log(institutions);
        $scope.institutions = institutions.data;
        $scope.usuario = {};
    };
    
    $scope.salvaUsuario = function () {
        if (!$scope.usuario) return;
        if ($scope.usuario.id) {
            api.institutions.put($scope.institution.idInstitution, institution).then(function (response) {
                $route.reload();
            });
        } else {
            api.institutions.post($scope.usuario).then(function (response) {
                $route.reload();
            });
        }
    };

    $scope.deleteUser = function (user) {
    console.log(user);
        api.institutions.delete(user.id).then(function (response) {
        	console.log('excluiu com sucess');
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