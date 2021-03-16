var DrawOverAppsPermission = function() {};

DrawOverAppsPermission.prototype.checkPermissions = function(success, fail) {
    cordova.exec(success, fail, "DrawOverAppsPermissionPlugin", "checkPermissions", []);
};

DrawOverAppsPermission.prototype.hasPermissions = function(success, fail) {
    cordova.exec(success, fail, "DrawOverAppsPermissionPlugin", "hasPermissions", []);
};

var drawOverAppsPermission = new DrawOverAppsPermission();
module.exports = drawOverAppsPermission;