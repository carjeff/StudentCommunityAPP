var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var bodyParser = require('body-parser');
var session = require('express-session');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var Router = require('./api/router');
var session_conf = require("./config/session_conf.js");

var app = express();
//改写文件
var http = require('http');
var server = http.createServer(app);

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({}));// extended: false
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

//app挂载bodyparser中间件
app.use(bodyParser.json());
app.use(bodyParser.urlencoded());



//为app挂载session中间件
app.use(session(session_conf));

//配置路由
app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/api', Router);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

//module.exports = app;
server.listen('8000');