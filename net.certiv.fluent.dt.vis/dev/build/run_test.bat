@echo off
setlocal
set PrjDir=D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.vis
set BldDir=%PrjDir%\dev\vis

@echo on
cd /d %BldDir%
cmd /k npm run test:unit

pause
rem timeout -T 10
