angular.module('institutions').factory('api', [ '$http', function ($http) {
    return    {
        institutions: {
            list: function () {
                return $http.get(`/ProjetoFinalGeison/PessoaServlet`);
            },
            post: function (usuario) {
                return $http.post(`/ProjetoFinalGeison/PessoaServlet`, usuario)
            },
            put: function (idUsuario, usuario) {
                return $http.put(`/ProjetoFinalGeison/PessoaServlet/${idUsuario}`, usuario);
            },
            delete: function (idUsuario) {
                return $http.delete(`/ProjetoFinalGeison/PessoaServlet/${idUsuario}`)
            },
            users: {
                reviews: {
                    get: function (idInstitution, idUser) {
                        return $http.get(`institutions/${idInstitution}/users/${idUser}/reviews`);
                    },
                    post: function (idInstitution, idUser, review) {
                        return $http.post(`institutions/${idInstitution}/users/${idUser}/reviews/`, review);
                    },
                    put: function (idInstitutions, idUser, idReview, review) {
                        return $http.put(`institutions/${idInstitutions}/users/${idUser}/reviews/${idReview}`, review);
                    }
                }
            }
        }
    }
}]);
