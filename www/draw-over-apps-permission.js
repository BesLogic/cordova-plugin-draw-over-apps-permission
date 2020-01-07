var DrawOverAppsPermission = function() {};

DrawOverAppsPermission.prototype.checkPermissions = function(success, fail) {
    cordova.exec(success, fail, "DrawOverAppsPermissionPlugin", "checkPermissions", []);
};

var drawOverAppsPermission = new DrawOverAppsPermission();
module.exports = drawOverAppsPermission;