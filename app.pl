#!/usr/bin/perl

my $remote_addr=$ENV{'REMOTE_ADDR'};

if ($ENV{'HTTP_ACCEPT'} eq 'application/json') {
  print "Content-type: application/json\n\n";
  print "{\"remote_addr\": \"$remote_addr\"}";
} else {
  print "Content-type: text/plain\n\n";
  print $remote_addr;
}

