#!/usr/bin/env bash
branch="dev"
user=uvdexdev
ip=67.205.175.109
if [ "$branch" = "origin/dev" ]; then
ssh uvdexdev@25.154.252.225 "cd uvdexdev.ithands.net && git status && git pull ssh_origin staging && php artisan migrate"
fi
