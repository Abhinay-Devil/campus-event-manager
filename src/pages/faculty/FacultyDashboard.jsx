import { useEffect, useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  Grid,
  Box,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  CircularProgress,
  List,
  ListItem,
  ListItemText,
} from "@mui/material";
import { Add as AddIcon, Event as EventIcon } from "@mui/icons-material";
import DashboardLayout from "../../components/admin/layout/Dashboard.jsx";
import API from "../../api/axios";

const FacultyDashboard = () => {
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [open, setOpen] = useState(false);
  const [newEvent, setNewEvent] = useState({
    title: "",
    description: "",
    date: "",
    time: "",
    location: "",
    capacity: "",
  });

  useEffect(() => {
    fetchEvents();
  }, []);

  const fetchEvents = () => {
    API.get("/events")
      .then((res) => {
        setEvents(res.data.content || res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  };

  const handleCreateEvent = () => {
    API.post("/events", newEvent)
      .then(() => {
        setOpen(false);
        setNewEvent({
          title: "",
          description: "",
          date: "",
          time: "",
          location: "",
          capacity: "",
        });
        fetchEvents();
      })
      .catch(console.error);
  };

  if (loading) {
    return (
      <DashboardLayout>
        <Box display="flex" justifyContent="center" alignItems="center" minHeight="400px">
          <CircularProgress />
        </Box>
      </DashboardLayout>
    );
  }

  return (
    <DashboardLayout>
      <Box display="flex" justifyContent="space-between" alignItems="center" mb={3}>
        <Typography variant="h4" component="h1">
          Faculty Dashboard
        </Typography>
        <Button
          variant="contained"
          startIcon={<AddIcon />}
          onClick={() => setOpen(true)}
        >
          Create Event
        </Button>
      </Box>

      <Grid container spacing={3}>
        <Grid item xs={12}>
          <Card>
            <CardContent>
              <Typography variant="h6" component="h2" gutterBottom>
                My Events
              </Typography>
              <List>
                {events.map((event) => (
                  <ListItem key={event.id}>
                    <EventIcon sx={{ mr: 2 }} />
                    <ListItemText
                      primary={event.title}
                      secondary={`${event.date} at ${event.time} - ${event.location}`}
                    />
                  </ListItem>
                ))}
              </List>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      <Dialog open={open} onClose={() => setOpen(false)} maxWidth="sm" fullWidth>
        <DialogTitle>Create New Event</DialogTitle>
        <DialogContent>
          <TextField
            autoFocus
            margin="dense"
            label="Title"
            fullWidth
            value={newEvent.title}
            onChange={(e) => setNewEvent({ ...newEvent, title: e.target.value })}
          />
          <TextField
            margin="dense"
            label="Description"
            fullWidth
            multiline
            rows={3}
            value={newEvent.description}
            onChange={(e) => setNewEvent({ ...newEvent, description: e.target.value })}
          />
          <TextField
            margin="dense"
            label="Date"
            type="date"
            fullWidth
            InputLabelProps={{ shrink: true }}
            value={newEvent.date}
            onChange={(e) => setNewEvent({ ...newEvent, date: e.target.value })}
          />
          <TextField
            margin="dense"
            label="Time"
            type="time"
            fullWidth
            InputLabelProps={{ shrink: true }}
            value={newEvent.time}
            onChange={(e) => setNewEvent({ ...newEvent, time: e.target.value })}
          />
          <TextField
            margin="dense"
            label="Location"
            fullWidth
            value={newEvent.location}
            onChange={(e) => setNewEvent({ ...newEvent, location: e.target.value })}
          />
          <TextField
            margin="dense"
            label="Capacity"
            type="number"
            fullWidth
            value={newEvent.capacity}
            onChange={(e) => setNewEvent({ ...newEvent, capacity: e.target.value })}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={() => setOpen(false)}>Cancel</Button>
          <Button onClick={handleCreateEvent} variant="contained">
            Create
          </Button>
        </DialogActions>
      </Dialog>
    </DashboardLayout>
  );
};

export default FacultyDashboard;